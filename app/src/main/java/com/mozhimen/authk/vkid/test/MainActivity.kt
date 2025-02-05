package com.mozhimen.authk.vkid.test

import android.os.Bundle
import com.mozhimen.authk.vkid.AuthKVKIDOnTapBottomSheetProxy
import com.mozhimen.authk.vkid.optins.OBuildApp_NeedManifestPlaceholders
import com.mozhimen.authk.vkid.optins.OBuildApp_NeedSecretsProperties
import com.mozhimen.authk.vkid.test.databinding.ActivityMainBinding
import com.mozhimen.uik.databinding.bases.activity.viewbinding.BaseActivityVB
import com.mozhimen.kotlin.lintk.optins.OApiCall_BindLifecycle
import com.mozhimen.kotlin.lintk.optins.OApiCall_BindViewLifecycle
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy

class MainActivity : BaseActivityVB<ActivityMainBinding>() {
    @OptIn(OApiInit_ByLazy::class, OApiCall_BindLifecycle::class, OApiCall_BindViewLifecycle::class, OBuildApp_NeedSecretsProperties::class, OBuildApp_NeedManifestPlaceholders::class)
    private val _authKVkidProxy: AuthKVKIDOnTapBottomSheetProxy<MainActivity> by lazy_ofNone { AuthKVKIDOnTapBottomSheetProxy(this) }

    @OptIn(OApiInit_ByLazy::class, OApiCall_BindLifecycle::class, OApiCall_BindViewLifecycle::class, OBuildApp_NeedSecretsProperties::class, OBuildApp_NeedManifestPlaceholders::class)
    override fun initView(savedInstanceState: Bundle?) {
        _authKVkidProxy.apply {
            bindLifecycle(this@MainActivity)
            isAutoAuth(false)
            initBottomSheet(R.id.main_one_tap_sheet)
        }

        vb.mainLoginVkid.setOnClickListener {
            _authKVkidProxy.showBottomSheet()
        }
    }
}