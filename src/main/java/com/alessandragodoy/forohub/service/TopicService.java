package com.alessandragodoy.forohub.service;

import com.alessandragodoy.forohub.dto.RequestCreateTopic;
import com.alessandragodoy.forohub.dto.TopicDTO;
import com.alessandragodoy.forohub.exception.ResourceNotFoundException;
import com.alessandragodoy.forohub.model.Course;
import com.alessandragodoy.forohub.model.Topic;
import com.alessandragodoy.forohub.model.UserForo;
import com.alessandragodoy.forohub.repository.CourseRepository;
import com.alessandragodoy.forohub.repository.TopicRepository;
import com.alessandragodoy.forohub.repository.UserForoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TopicService {
	private final TopicRepository topicRepository;
	private final UserForoRepository userForoRepository;
	private final CourseRepository courseRepository;

	public Page<TopicDTO> getAllTopics(Pageable pageable) {
		return topicRepository.findAll(pageable).map(TopicDTO::new);
	}

	public TopicDTO getTopicById(Long id) {
		return topicRepository.findById(id)
				.map(TopicDTO::new)
				.orElseThrow(() -> new ResourceNotFoundException("There is " +
				"no topic with id " + id + "."));
	}

	@Transactional
	public TopicDTO createTopic(RequestCreateTopic request) {
		UserForo user = userForoRepository.findByEmail(request.email())
				.orElseThrow(() -> new ResourceNotFoundException("The email " + request.email() + " is unregistered."));

		Course course = courseRepository.findByNameIgnoreCase(request.course().toLowerCase())
				.orElseThrow(() -> new ResourceNotFoundException("The course '" + request.course() + "' does not exist."));

		Topic topic = new Topic(request, LocalDateTime.now(), user, course);
		topicRepository.save(topic);

		return new TopicDTO(topic);
	}
}
