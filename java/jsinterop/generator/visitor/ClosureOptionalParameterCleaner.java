/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package jsinterop.generator.visitor;

import static jsinterop.generator.helper.GeneratorUtils.toSafeTypeName;

import java.util.HashSet;
import java.util.Set;
import jsinterop.generator.model.Method;
import jsinterop.generator.model.Method.Parameter;

/**
 * Closure requires that optional parameters are prefixed by <code>opt_</code>. In Java, we create a
 * method overloading for each optional parameters. This visitor removes the unneeded prefix <code>
 * opt_</code>.
 */
public class ClosureOptionalParameterCleaner extends AbstractModelVisitor {
  private final Set<String> parameterNames = new HashSet<>();

  @Override
  public boolean visit(Method method) {
    parameterNames.clear();
    return true;
  }

  @Override
  public boolean visit(Parameter parameter) {
    if (parameter.getName().startsWith("opt_")) {
      parameter.setName(toSafeTypeName(parameter.getName().substring(4), parameterNames));
    }

    parameterNames.add(parameter.getName());
    return true;
  }
}
