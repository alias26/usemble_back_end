package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Review;
import com.mycompany.webapp.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;

	@PostMapping("/write")
	public Map<String, String> writeReview(@RequestBody Review review) {
		Map<String, String> map = new HashMap<>();

		reviewService.write(review);

		map.put("response", "success");

		return map;
	}

	@GetMapping("/state")
	public Map<String, Object> isReview(Review review) {
		boolean isReview = reviewService.isReview(review);

		Map<String, Object> map = new HashMap<>();

		map.put("response", "success");
		map.put("isReview", isReview);

		return map;
	}

	@GetMapping("/read")
	public Map<String, Object> readReview(Review review) {
		Review data = reviewService.readReview(review);

		Map<String, Object> map = new HashMap<>();

		map.put("response", "success");
		map.put("review", data);

		return map;
	}

	@PatchMapping("/update")
	public Map<String, Object> updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);

		Map<String, Object> map = new HashMap<>();

		map.put("response", "success");

		return map;
	}

	@DeleteMapping("/delete")
	public Map<String, Object> deleteReview(Review review) {
		reviewService.deleteReview(review);

		Map<String, Object> map = new HashMap<>();

		map.put("response", "success");

		return map;
	}
}
