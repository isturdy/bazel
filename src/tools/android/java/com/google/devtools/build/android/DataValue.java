// Copyright 2016 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.android;

import com.google.devtools.build.android.AndroidDataSerializer.SerializeEntryVisitor;
import java.io.IOException;

/**
 * Represents the value associated with DataKey interface for resource and asset values.
 *
 * <p>A DataValue is either an android resource or asset derived from a Path.
 */
public interface DataValue {

  /**
   * Provides the DataSource, which contains metadata about the original xml it was derived from.
   */
  DataSource source();

  /** Serializes the value to the entry visitor. */
  SerializeEntryVisitor serializeTo(SerializeEntryVisitor visitor) throws IOException;

  DataValue update(DataSource source);

  /** Provides a representation of the value suitable for a conflict message. */
  String asConflictString();

  /**
   * Ignores metadata in the DataValue object and returns true if the value properties are
   * equivalent to another given DataValue object
   */
  boolean valueEquals(DataValue value);
}
