package com.mozhimen.authk.vkid.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mozhimen.authk.vkid.AuthKVKIDOnTapBottomSheet
import com.mozhimen.authk.vkid.optins.OBuildApp_NeedManifestPlaceholders
import com.mozhimen.authk.vkid.optins.OBuildApp_NeedSecretsProperties
import com.mozhimen.authk.vkid.test.databinding.ActivityMainBinding
import com.mozhimen.basick.elemk.androidx.appcompat.bases.viewbinding.BaseActivityVB
import com.mozhimen.basick.lintk.optins.OApiCall_BindLifecycle
import com.mozhimen.basick.lintk.optins.OApiCall_BindViewLifecycle
import com.mozhimen.basick.lintk.optins.OApiInit_ByLazy

class MainActivity : BaseActivityVB<ActivityMainBinding>() {
    @OptIn(OApiInit_ByLazy::class, OApiCall_BindLifecycle::class, OApiCall_BindViewLifecycle::class, OBuildApp_NeedSecretsProperties::class, OBuildApp_NeedManifestPlaceholders::class)
    private val _authKVkidProxy: AuthKVKIDOnTapBottomSheet<MainActivity> by lazy { AuthKVKIDOnTapBottomSheet(this) }

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