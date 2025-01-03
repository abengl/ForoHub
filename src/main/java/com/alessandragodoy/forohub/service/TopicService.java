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
import java.util.Optional;

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
		UserForo user = userForoRepository.findByEmailIgnoreCase(request.email())
				.orElseThrow(() -> new ResourceNotFoundException("The email " + request.email() + " is unregistered."));

		Course course = courseRepository.findByNameIgnoreCase(request.course().toLowerCase())
				.orElseThrow(() -> new ResourceNotFoundException("The course '" + request.course() + "' does not exist."));

		Topic topic = new Topic(request, LocalDateTime.now(), user, course);
		topicRepository.save(topic);

		return new TopicDTO(topic);
	}

	@Transactional
	public TopicDTO updateTopic(RequestCreateTopic request, Long id) {
		Topic topic = topicRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no topic with id " + id + "."));

		if (!request.title().equalsIgnoreCase(topic.getTitle())) {
			topic.setTitle(request.title());
		}

		if (!request.message().equalsIgnoreCase(topic.getMessage())) {
			topic.setMessage(request.message());
		}

		if (!request.email().equalsIgnoreCase(topic.getAuthor().getEmail())) {
			topic.getAuthor().setEmail(request.email());
		}

		if (!request.course().equalsIgnoreCase(topic.getCourse().getName())) {
			Optional<Course> course = courseRepository.findByNameIgnoreCase(request.course());
			if (course.isPresent()) {
				topic.setCourse(course.get());
			} else {
				throw new ResourceNotFoundException("The course is not valid.");
			}
		}

		topicRepository.save(topic);

		return new TopicDTO(topic);
	}

	@Transactional
	public void deleteTopic(Long id) {
		boolean topicExistsById = topicRepository.existsById(id);
		if (topicExistsById) {
			topicRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("There is no topic with id " + id + ".");
		}
	}
}
