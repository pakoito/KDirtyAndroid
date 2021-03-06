/*
 * Copyright 2017 Victor Albertos
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

package app.data.foundation.net

import io.reactivex.Single
import io.reactivex.SingleTransformer
import retrofit2.Response
import javax.inject.Inject

/**
 * Process a network response. On success returns the associated data. On error throws a
 * NetworkException to be able to detect it as a custom exception to be handled properly by the
 * downstream.
 * @see NetworkException
 */
class NetworkResponse @Inject constructor(val errorAdapter: ErrorAdapter) {

    fun <T> process(): SingleTransformer<Response<T>, T> {
        return SingleTransformer {
            it.flatMap {
                if (it.isSuccessful) {
                    Single.just(it.body())
                } else {
                    try {
                        val error = errorAdapter.adapt(it.errorBody().string())
                        Single.error<T>(NetworkException(error))
                    } catch (exception: java.lang.Exception) {
                        Single.error<T>(RuntimeException(exception))
                    }
                }
            }

        }
    }
}

open class NetworkException(message: String) : RuntimeException(message)
