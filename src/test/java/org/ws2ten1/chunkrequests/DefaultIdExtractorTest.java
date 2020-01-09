/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ws2ten1.chunkrequests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;

import lombok.RequiredArgsConstructor;

import org.junit.Test;

/**
 * Test for {@link DefaultIdExtractor}.
 */
public class DefaultIdExtractorTest {
	
	@Test
	public void testMirageEntity() {
		// setup
		DefaultIdExtractor sut = new DefaultIdExtractor();
		// exercise
		Serializable actual = sut.apply(new MirageEntity("aaa"));
		// verify
		assertThat(actual).isEqualTo("aaa");
	}
	
	@Test
	public void testJpaEntity() {
		// setup
		DefaultIdExtractor sut = new DefaultIdExtractor();
		// exercise
		Serializable actual = sut.apply(new JpaEntity("bbb"));
		// verify
		assertThat(actual).isEqualTo("bbb");
	}
	
	
	@RequiredArgsConstructor
	private static class MirageEntity {
		
		@org.springframework.data.annotation.Id
		private final String id;
	}
	
	@RequiredArgsConstructor
	private static class JpaEntity {
		
		@javax.persistence.Id
		private final String id;
	}
}
