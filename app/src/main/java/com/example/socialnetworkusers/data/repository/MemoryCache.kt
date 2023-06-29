package com.example.socialnetworkusers.data.repository

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.LruCache

object MemoryCache {
    private val cache: LruCache<String, Drawable>
    private const val cacheSize = 10 * 1024 * 1024

    init {
        cache = object : LruCache<String, Drawable>(cacheSize) {
            override fun sizeOf(key: String, drawable: Drawable): Int {

                return getDrawableByteCount(drawable)
            }
        }
    }

    fun put(key: String, drawable: Drawable) {
        cache.put(key, drawable)
    }

    fun get(key: String): Drawable? {
        return cache.get(key)
    }


    private fun getDrawableByteCount(drawable: Drawable): Int {
        if (drawable is BitmapDrawable) {
            val bitmap = drawable.bitmap
            return getBitmapByteCount(bitmap)
        }
        return 0
    }

    private fun getBitmapByteCount(bitmap: Bitmap): Int {
        return bitmap.allocationByteCount
    }
}