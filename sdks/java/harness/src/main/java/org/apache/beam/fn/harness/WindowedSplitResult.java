/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.fn.harness;

import com.google.auto.value.AutoValue;
import org.apache.beam.sdk.annotations.Internal;
import org.apache.beam.sdk.values.WindowedValue;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.Pure;

/** Internal class to hold the primary and residual roots when converted to an input element. */
@AutoValue
@AutoValue.CopyAnnotations
@Internal
abstract class WindowedSplitResult {
  public static WindowedSplitResult forRoots(
      @Nullable WindowedValue<?> primaryInFullyProcessedWindowsRoot,
      @Nullable WindowedValue<?> primarySplitRoot,
      @Nullable WindowedValue<?> residualSplitRoot,
      @Nullable WindowedValue<?> residualInUnprocessedWindowsRoot) {
    return new AutoValue_WindowedSplitResult(
        primaryInFullyProcessedWindowsRoot,
        primarySplitRoot,
        residualSplitRoot,
        residualInUnprocessedWindowsRoot);
  }

  @Pure
  public abstract @Nullable WindowedValue<?> getPrimaryInFullyProcessedWindowsRoot();

  @Pure
  public abstract @Nullable WindowedValue<?> getPrimarySplitRoot();

  @Pure
  public abstract @Nullable WindowedValue<?> getResidualSplitRoot();

  @Pure
  public abstract @Nullable WindowedValue<?> getResidualInUnprocessedWindowsRoot();
}
