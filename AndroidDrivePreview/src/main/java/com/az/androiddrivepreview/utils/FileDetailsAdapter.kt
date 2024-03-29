package com.az.androiddrivepreview.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.az.androiddrivepreview.R
import com.az.androiddrivepreview.data.models.ItemType

/**
 * File details adapter
 *
 * @constructor Create empty File details adapter
 */
class FileDetailsAdapter {


    /**
     * Get icon from mime type
     *
     * @param context
     * @param mimeType
     * @return
     */// return an icon as a drawable basing on the mimetype
    fun getIconFromMimeType(context: Context, mimeType: String): Drawable? {
        if (fileOrDirectory(mimeType) == ItemType.FOLDER) {
            return ContextCompat.getDrawable(context, R.drawable.icon_folder)
        }

        return when {
            mimeType.startsWith("image/") -> {
                when (mimeType) {
                    "image/gif" -> ContextCompat.getDrawable(context, R.drawable.icon_gif)
                    "image/jpeg" -> ContextCompat.getDrawable(context, R.drawable.icon_jpg)
                    "image/png" -> ContextCompat.getDrawable(context, R.drawable.icon_png)
                    "image/svg+xml" -> ContextCompat.getDrawable(context, R.drawable.icon_svg)
                    else -> ContextCompat.getDrawable(context, R.drawable.icon_img) // For other image types
                }
            }
            mimeType == "application/pdf" -> ContextCompat.getDrawable(context, R.drawable.icon_pdf)
            mimeType == "audio/mpeg" -> ContextCompat.getDrawable(context, R.drawable.icon_mp3)
            mimeType == "video/x-msvideo" -> ContextCompat.getDrawable(context, R.drawable.icon_avi)
            mimeType == "video/x-matroska" -> ContextCompat.getDrawable(context, R.drawable.icon_mkv)
            mimeType == "application/zip" -> ContextCompat.getDrawable(context, R.drawable.icon_zip)
            mimeType == "image/vnd.adobe.photoshop" -> ContextCompat.getDrawable(context, R.drawable.icon_psd)
            mimeType == "text/plain" -> ContextCompat.getDrawable(context, R.drawable.icon_txt)
            mimeType == "application/illustrator" -> ContextCompat.getDrawable(context, R.drawable.icon_ai)
            mimeType == "application/msword" -> ContextCompat.getDrawable(context, R.drawable.icon_doc)
            mimeType == "application/vnd.openxmlformats-officedocument.wordprocessingml.document" -> ContextCompat.getDrawable(context, R.drawable.icon_doc)
            mimeType == "application/vnd.ms-powerpoint" -> ContextCompat.getDrawable(context, R.drawable.icon_ppt)
            mimeType == "application/vnd.openxmlformats-officedocument.presentationml.presentation" -> ContextCompat.getDrawable(context, R.drawable.icon_ppt)
            mimeType == "application/vnd.ms-excel" -> ContextCompat.getDrawable(context, R.drawable.icon_xls)
            mimeType == "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" -> ContextCompat.getDrawable(context, R.drawable.icon_xls)
            mimeType == "application/json" -> ContextCompat.getDrawable(context, R.drawable.icon_json)
            mimeType == "text/csv" -> ContextCompat.getDrawable(context, R.drawable.icon_csv)
            mimeType == "application/x-rar-compressed" -> ContextCompat.getDrawable(context, R.drawable.icon_rar) // Adding RAR icon
            mimeType == "application/x-zip-compressed" -> ContextCompat.getDrawable(context, R.drawable.icon_zip) // Adding RAR icon
            else -> ContextCompat.getDrawable(context, R.drawable.icon_other) // Replace with a default icon
        }
    }

    /**
     * File or directory
     *
     * @param mimeType
     * @return
     *///check if the file is a folder or a file
    fun fileOrDirectory(mimeType: String): ItemType {
        return if (mimeType == "application/vnd.google-apps.folder"){
            ItemType.FOLDER
        }else{
            ItemType.FILE
        }
    }

    /**
     * Format size
     *
     * @param size
     * @return
     */// format the file size to a presentable text
    fun formatSize(size: Long): String {
        return when {
            size == 0L -> {
                "0 B"  // Display "0 B" for zero size
            }
            size >= 1000L * 1000L * 1000L -> {
                "${size / 1000 / 1000 / 1000} GB"
            }
            size >= 1000L * 1000L -> {
                "${size / 1000 / 1000} MB"
            }
            size >= 1000L -> {
                "${size / 1000} KB"
            }
            else -> {
                "$size B"
            }
        }
    }


}