/*
 * Copyright 2020 The Android Open Source Project
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

package com.live.allo.buildsrc

// Gradle 插件版本相关配置
object Versions {
    const val ktlGradleTools = "7.3.1"
    const val ktlGradlePlugin = "1.6.10"
    const val ktlDagger = "2.41"

    const val jvmTarget = "1.8"
    const val kotlinCompilerExtensionVersion = "1.1.1"
}

// 应用基础信息相关配置
object AppInfoBase {
    const val applicationId = "com.live.allo"
    const val buildToolsVersion = "30.0.3"
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 32
    const val versionCode = 10000
    const val versionName = "1.0.000"
}

// Gradle 插件
object GradleDependencies {
    const val tools = "com.android.tools.build:gradle:${Versions.ktlGradleTools}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.ktlGradlePlugin}"
    const val dagger = "com.google.dagger:hilt-android-gradle-plugin:${Versions.ktlDagger}"
}

// 依赖 lib
object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-beta03"
    const val jdkDesugar = "com.android.tools:desugar_jdk_libs:1.0.9"
    const val junit = "junit:junit:4.13"
    const val material = "com.google.android.material:material:1.3.0"

    object Accompanist {
        const val version = "0.10.0"
        const val coil = "com.google.accompanist:accompanist-coil:$version"
    }

    // kotlin
    object Kotlin {
        private const val version = "1.4.32"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    // 协程
    object Coroutines {
        private const val version = "1.4.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    // 依赖注入框架 hilt
    object Google {
        private const val version = "2.41"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    // androidX 替换 support
    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
        const val coreKtx = "androidx.core:core-ktx:1.6.0-alpha03"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        // 生命周期管理
        object Lifecycle {
            private const val version = "2.3.1"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha05"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha08"
        }

        // compose ui
        object Compose {
            const val snapshot = ""
            const val ui_version = "1.1.1"
            const val activity_version = "1.3.1"

            @get:JvmStatic
            val snapshotUrl: String
                get() = "https://androidx.dev/snapshots/builds/$snapshot/artifacts/repository/"

            const val activity_compose = "androidx.activity:activity-compose:$activity_version"
            const val ui = "androidx.compose.ui:ui:$ui_version"
            const val ui_tooling = "androidx.compose.ui:ui-tooling-preview:$ui_version"
            const val material = "androidx.compose.material:material:$ui_version"

            const val foundation = "androidx.compose.foundation:foundation:$ui_version"
            const val layout = "androidx.compose.foundation:foundation-layout:$ui_version"

            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$ui_version"
            const val runtime = "androidx.compose.runtime:runtime:$ui_version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$ui_version"
        }

        // fragment管理
        object Navigation {
            private const val version = "2.3.4"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        // Material 设计ui
        object Material {
            private const val version = "1.3.0"
            const val material = "com.google.android.material:material:$version"
        }

        // 约束布局
        object Layout {
            private const val version = "2.0.4"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
        }

        /**
         * DataStore 提供两种不同的实现：Preferences DataStore 和 Proto DataStore。
         * Preferences DataStore 使用键存储和访问数据。此实现不需要预定义的架构，也不确保类型安全。
         * Proto DataStore 将数据作为自定义数据类型的实例进行存储。此实现要求您使用协议缓冲区来定义架构，但可以确保类型安全。
         */
        object Datastore {
            //Proto DataStore
            private const val version = "1.0.0-beta01"
            const val datastore = "androidx.datastore:datastore:$version"
            const val datastore_rxjava2 = "androidx.datastore:datastore-rxjava2:$version"
            const val datastore_rxjava3 = "androidx.datastore:datastore-rxjava3:$version"
            const val core = "androidx.datastore:datastore-core:$version"

            //Preferences DataStore
            const val datastore_preferences = "androidx.datastore:datastore-preferences:$version"
            const val datastore_preferences_rxjava2 =
                "androidx.datastore:datastore-preferences-rxjava2:$version"
            const val datastore_preferences_rxjava3 =
                "androidx.datastore:datastore-preferences-rxjava3:$version"
            const val preferences_core = "androidx.datastore:datastore-core:$version"
        }

        // sqlite 数据库orm框架
        object Room {
            private const val version = "2.2.5"
            const val runtime = "androidx.room:room-runtime:$version"
            const val ktl = "androidx.room:room-ktx:$version"
            const val compiler = "androidx.room:room-compiler:$version"
        }

        // workManger 后台任务
        object Work {
            private const val version = "2.4.0"
            const val ktx = "androidx.work:work-runtime-ktx:$version"
        }

        // 测试相关
        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    // 网络请求框架 Retrofit
    object SquareUp {
        // retrofit 来源： https://github.com/square/retrofit
        object Retorfit {
            private const val version = "2.9.0"
            const val retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val adapter = "com.squareup.retrofit2:adapter-rxjava3:$version"
            const val converter = "com.squareup.retrofit2:converter-gson:$version"
        }

        object OkHttp3 {
            private const val version = "3.8.1"
            const val okhttp = "com.squareup.okhttp3:okhttp:$version"
            const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        }
    }

    // refresh 刷新动画 来源：https://github.com/scwang90/SmartRefreshLayout
    object scwang {
        private const val version = "2.0.3"
        const val header_two_level = "com.scwang.smart:refresh-header-two-level:$version"
        const val refresh_layout_kernel = "com.scwang.smart:refresh-layout-kernel:$version"
    }

    // logger 日志框架 来源：https://github.com/orhanobut/logger
    object orhanobut {
        private const val version = "2.2.0"
        const val logger = "com.orhanobut:logger:$version"
    }

    // xlog 日志框架 来源：https://github.com/elvishew/xLog
    object elvishew {
        private const val version = "1.10.1"
        const val xlog = "com.elvishew:xlog:$version"
    }

    // banner 来源：https://github.com/youth5201314/banner
    object youth {
        private const val version = "2.2.2"
        const val banner = "io.github.youth5201314:banner:$version"
    }

    // BaseRecyclerViewAdapterHelper BRAVH 来源：https://github.com/CymChad/BaseRecyclerViewAdapterHelper
    object cymchad {
        private const val version = "3.0.4"
        const val bravh = "com.github.CymChad:BaseRecyclerViewAdapterHelper:$version"
    }

    // customer tabLayout 来源：https://github.com/hackware1993/MagicIndicator
    object hackware1993 {
        private const val version = "1.7.0"
        const val MagicIndicator = "com.github.hackware1993:MagicIndicator:$version"
    }

    // badge view 小圆点 支持拖动消除动画 来源：https://github.com/qstumn/BadgeView
    object qstumn {
        private const val version = "1.1.3"
        const val badgeview = "q.rorbin:badgeview:$version"
    }

    // ImmersionBar 沉浸状态栏 来源： https://github.com/gyf-dev/ImmersionBar
    object gyfdev {
        private const val version = "3.0.0"
        const val immersionbar = "com.gyf.immersionbar:immersionbar:$version"   // 基础依赖包，必须要依赖
        const val immersionbar_components =
            "com.gyf.immersionbar:immersionbar-components:$version"    // fragment快速实现（可选）
        const val immersionbar_ktx =
            "com.gyf.immersionbar:immersionbar-ktx:$version"         // kotlin扩展（可选）
    }

    //CBRatingBar 来源： https://github.com/MrLiGitHub/RatingBar
    object cbysx {
        private const val version = "0.1.1"
        const val CBRatingBar = "com.xl.ratingbar:ratingbar:$version"
    }

    // glide 来源： https://github.com/bumptech/glide
    object bumptech {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val integration = "com.github.bumptech.glide:okhttp3-integration:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    // autoDispose RxJava生命周期绑定工具 来源： https://github.com/uber/AutoDispose
    object uber {
        private const val version = "2.0.0"
        const val android = "com.uber.autodispose2:autodispose-android:$version"
        const val lifecycle = "com.uber.autodispose2:autodispose-androidx-lifecycle:$version"
    }

    // event-bus LiveDataEventBus 来源： https://github.com/JeremyLiao/LiveEventBus
    object jeremyliao {
        private const val version = "1.8.0"
        const val eventBus = "io.github.jeremyliao:live-event-bus-x:$version"
    }

    // SKU 来源：https://github.com/wuhenzhizao/android-sku
    object wuhenzhizao {
        private const val version = "1.0.4"
        const val sku = "com.wuhenzhizao:sku:$version"
    }

    // zcweng SwithButton 来源： https://github.com/zcweng/SwitchButton
    object zcweng {
        private const val version = "0.0.3"
        const val switchbutton = "com.github.zcweng:switch-button:$version@aar"
    }

    // SwipeRecycleView 来源： https://github.com/yanzhenjie/SwipeRecyclerView
    object yanzhenjie {
        private const val version = "1.3.2"
        const val recyclerview = "com.yanzhenjie.recyclerview:x:$version"
    }

    // wang AVLoadingIndicatorView 加载动画  来源： https://github.com/HarlonWang/AVLoadingIndicatorView
    object wang {
        private const val version = "2.1.3"
        const val library = "com.wang.avi:library:$version"
    }

    // 数据倒灌解决方案unpeek 来源： https://github.com/KunMinX/UnPeek-LiveData
    object kunminx {
        private const val version = "6.1.0-beta1"
        const val unpeek = "com.kunminx.arch:unpeek-livedata:$version"
    }

    // zxing 来源：https://github.com/yipianfengye/android-zxingLibrary
    object yipianfengye {
        private const val version = "2.2"
        const val zxing = "cn.yipianfengye.android:zxing-library:$version"
    }

    // xxpermission 来源： https://github.com/getActivity/XXPermissions
    object getActivity {
        private const val version = "12.3"
        const val permission = "com.github.getActivity:XXPermissions:$version"
    }

    // 图片查看器
    object SherlockGougou {
        private const val version = "androidx-6.2.0"
        const val bigImageViewPager = "com.github.SherlockGougou:BigImageViewPager:$version"
    }

    // RxView 来源： https://github.com/JakeWharton/RxBinding
    object jakewharton {
        private const val version = "4.0.0"
        const val runtime = "com.jakewharton.rxbinding4:rxbinding:$version"
    }

    // 换肤框架 来源： https://github.com/ximsfei/Android-skin-support
    object ximsfei {
        private const val version = "4.0.5"
        const val runtime = "skin.support:skin-support:$version"// skin-support
        const val appcompat = "sskin.support:skin-support-appcompat:$version"// skin-support 基础控件支持
        const val design =
            "skin.support:skin-support-design:$version"// skin-support-design material design 控件支持[可选]
        const val cardview =
            "skin.support:skin-support-cardview:$version"// skin-support-cardview CardView 控件支持[可选]
        const val layout =
            "skin.support:skin-support-constraint-layout:$version"// skin-support-constraint-layout ConstraintLayout 控件支持[可选]
    }

    // 柯基 通用工具类
    // 依赖 AndroidX https://github.com/Blankj/AndroidUtilCode/blob/master/lib/utilcode/README-CN.md
    // 非依赖源 https://github.com/Blankj/AndroidUtilCode/blob/master/lib/subutil/README-CN.md
    object blankj {
        private const val ucVersion = "1.31.1"
        const val runtime = "com.blankj:utilcodex:$ucVersion"
    }

    // svga播放器 https://github.com/svga/SVGAPlayer-Android
    object yyued {
        private const val version = "latest"
        const val runtime = "com.github.yyued:SVGAPlayer-Android:$version"
    }

    // 内存检测 来源： https://github.com/square/leakcanary
    object leakcanary {
        private const val version = "2.7"
        const val leakcanary_android = "com.squareup.leakcanary:leakcanary-android:$version"
    }

    // bugly 腾讯错误收集
    object tencent {
        private const val version = "latest.release"
        const val crashreport = "com.tencent.bugly:crashreport:$version"
        const val crashreport_upgrade = "com.tencent.bugly:crashreport_upgrade:$version"
        const val nativecrashreport = "com.tencent.bugly:nativecrashreport:$version"
    }

    // 微信开放平台sdk
    object WeChat {
        private const val version = ""
        const val openSdk = "com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+"
    }

}
