/*
 * Copyright 2013-2024, Seqera Labs
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
 *
 */

package nextflow.gpt.client

import groovy.transform.CompileStatic
import groovy.transform.ToString
/**
 * Model the GPT chat conversation response object
 *
 * See also
 * https://platform.openai.com/docs/api-reference/chat/object
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@CompileStatic
@ToString(includePackage = false, includeNames = true)
class GptChatCompletionResponse {

    @ToString(includePackage = false, includeNames = true)
    static class Choice {
        String finish_reason
        Integer index
        Message message
    }

    @ToString(includePackage = false, includeNames = true)
    static class Message {
        String role
        String content
        List<ToolCall> tool_calls
    }

    @ToString(includePackage = false, includeNames = true)
    static class ToolCall {
        String id
        String type
        Function function
    }

    @ToString(includePackage = false, includeNames = true)
    static class Function {
        String name
        String arguments
    }

    String id
    String object
    Long created
    String model
    List<Choice> choices
}
