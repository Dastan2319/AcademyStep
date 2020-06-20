package kz.example.academystep

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PermissionActivity:AppCompatActivity() {

    var btnCamera:Button?=null;
    var btnCall:Button?=null;
    var REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initView();
        initListener();
    }

    fun initView(){
        btnCamera=findViewById(R.id.btnCamera);
        btnCall=findViewById(R.id.btnCall);

    }

    fun initListener(){
        btnCamera!!.setOnClickListener(View.OnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ camera->
                camera.resolveActivity(packageManager)?.also{
                    startActivityForResult(camera,REQUEST_IMAGE_CAPTURE)
                }

            }
        })
        btnCall!!.setOnClickListener(View.OnClickListener {
            val toDial = "tel:87024800147"
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(toDial)))
        })
    }

}