package com.alessandragodoy.forohub.service;

import com.alessandragodoy.forohub.dto.TopicDTO;
import com.alessandragodoy.forohub.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TopicService {
	private final TopicRepository topicRepository;

	public Page<TopicDTO> getAllTopics(Pageable pageable) {
		return topicRepository.findAll(pageable).map(TopicDTO::new);
	}
}
