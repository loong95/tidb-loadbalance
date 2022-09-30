/*
 * Copyright 2021 TiDB Project Authors.
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

package com.tidb.jdbc;

import java.util.function.Function;

import com.tidb.jdbc.impl.Backend;
import org.junit.Assert;

public class MockUrlMapper implements Function<Backend, String[]> {

  public Backend result;
  private String[] expected;

  MockUrlMapper(Backend result, String[] expected) {
    this.result = result;
    this.expected = expected;
  }

  void setResult(Backend result) {
    this.result = result;
  }

  @Override
  public String[] apply(Backend args) {
    Assert.assertArrayEquals(args.getBackend(), expected);
    return expected;
  }
}
