package co.aurasphere.courseware.j2ee.spring.boot.webflux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/courseware")
public class CoursewareWebfluxController {

	@GetMapping("/list")
	public Flux<ControllerResponse> getWebfluxList(@RequestParam("size") Integer listSize) {
		List<ControllerResponse> elementsList = Stream.generate(ControllerResponse::new).limit(listSize)
				.collect(Collectors.toList());
		return Flux.fromIterable(elementsList);
	}

	@GetMapping("/single")
	public Mono<ControllerResponse> getWebfluxSingleElement() {
		return Mono.fromSupplier(ControllerResponse::new);
	}
}