package com.mozhimen.authk.vkid

import android.app.Activity
import androidx.annotation.IdRes
import androidx.lifecycle.LifecycleOwner
import com.mozhimen.authk.vkid.optins.OBuildApp_NeedManifestPlaceholders
import com.mozhimen.authk.vkid.optins.OBuildApp_NeedSecretsProperties
import com.mozhimen.basick.elemk.androidx.lifecycle.bases.BaseWakeBefDestroyLifecycleObserver
import com.mozhimen.basick.lintk.optins.OApiCall_BindLifecycle
import com.mozhimen.basick.lintk.optins.OApiCall_BindViewLifecycle
import com.mozhimen.basick.lintk.optins.OApiInit_ByLazy
import com.vk.id.onetap.xml.OneTapBottomSheet

/**
 * @ClassName AuthKVKIDOnTapBottomSheet
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/5
 * @Version 1.0
 */
@OApiInit_ByLazy
@OApiCall_BindLifecycle
@OApiCall_BindViewLifecycle
@OBuildApp_NeedSecretsProperties
@OBuildApp_NeedManifestPlaceholders
class AuthKVKIDOnTapBottomSheet<A>(private var _activity: A?) : BaseWakeBefDestroyLifecycleObserver() where  A : LifecycleOwner, A : Activity {
    private var _oneTapBottomSheet: OneTapBottomSheet? = null
    private var _isAutoAuth: Boolean = false

    /////////////////////////////////////////////////////////////

    fun isAutoAuth(boolean: Boolean) {
        _isAutoAuth = boolean
    }

    fun initBottomSheet(@IdRes intResId: Int) {
        _oneTapBottomSheet = _activity?.findViewById(intResId)
    }

    fun showBottomSheet() {
        _oneTapBottomSheet?.show()
    }

    /////////////////////////////////////////////////////////////

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if (_isAutoAuth)
            showBottomSheet()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        _oneTapBottomSheet = null
        _activity = null
        super.onDestroy(owner)
    }
}