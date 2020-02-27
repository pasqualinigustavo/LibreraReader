package com.foobnix.ui2

import android.content.Context
import android.os.Bundle

import com.foobnix.pdf.info.Android6
import com.foobnix.pdf.info.BuildConfig
import com.foobnix.pdf.info.ExtUtils
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class MainActivitySeeBook : AdsFragmentActivity() {

    companion object {

        private val DATABASE_NAME = "livro2.epub"
        private val DATABASE_PATH = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/"
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(MyContextWrapper.wrap(context))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        if (!Android6.canWrite(this)) {
            Android6.checkPermissions(this, true)
            return
        }

        copyDBFromAssetsFolder()
        val f = File("$DATABASE_PATH/$DATABASE_NAME")
        ExtUtils.showDocumentWithoutDialog(this, f, null)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Android6.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
    }

    override fun onFinishActivity() {
        finish()
    }

    private fun copyDBFromAssetsFolder() {
        var `is`: InputStream? = null
        try {
            //lê o arquivo da pasta assets
            `is` = assets.open(DATABASE_NAME)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            val fileDir = File(DATABASE_PATH)
            fileDir.mkdirs()
            val f = File("$DATABASE_PATH/$DATABASE_NAME")
            f.createNewFile()
            val fos = FileOutputStream(f)
            fos.write(buffer)
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
