/*
 * Copyright 2015-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.release;

import java.util.Base64;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.support.logging.HandlerUtils;

/**
 * @author Oliver Gierke
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		System.out.println(new String(Base64.getDecoder().decode("amVua2lucy5zcHJpbmcuaW8=")));
		System.out.println(new String(Base64.getDecoder().decode("amVua2lucy5zcHJpbmcuaW86Y21WbWRHdHVPakF4T2pFMk9Ua3hNelE1TmpJNmJWUjBiak5OZW5FeFVVTkRNMVJuWVdFMWVYbEhURFpQYm1kTw==")));

		SpringApplication application = new SpringApplication(Application.class);
		application.setAdditionalProfiles("local");

		try {
			BootShim bs = new BootShim(args, application.run(args));
			bs.run();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			HandlerUtils.flushAllHandlers(Logger.getLogger(""));
		}
	}
}
