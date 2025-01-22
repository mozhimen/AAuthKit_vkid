-keep class com.vk.dto.common.id.UserId { *; }
# authk_vkid
# https://issuetracker.google.com/issues/195752905
-dontwarn com.google.errorprone.annotations.*
-keep class android.content.Context { *; }
-keep class com.google.crypto.tink.** { *; }