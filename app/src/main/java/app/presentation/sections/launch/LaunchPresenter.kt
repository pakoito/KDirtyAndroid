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

package app.presentation.sections.launch

import app.presentation.foundation.presenter.Presenter
import app.presentation.foundation.presenter.ViewPresenter
import app.presentation.foundation.transformations.Transformations
import app.presentation.foundation.widgets.Notifications
import javax.inject.Inject

class LaunchPresenter @Inject constructor(transformations: Transformations,
                                                   private val wireframe: LaunchWireframe,
                                                   notifications: Notifications) : Presenter<LaunchPresenter.View>(transformations, notifications) {

    override fun onBindView(view: LaunchPresenter.View) {
        super.onBindView(view)
        wireframe.dashboard().subscribe()
    }

    interface View : ViewPresenter
}
