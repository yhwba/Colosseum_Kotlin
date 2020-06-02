package kr.co.yhw.colosseum_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import kr.co.yhw.colosseum_kotlin.utils.serverUtil
import org.json.JSONObject

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {
            val email = emailEdt.text.toString()
            val pw = pwEdt.text.toString()

            serverUtil.postRequestLogin(mContext,email,pw,object : serverUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("로그인응답",json.toString())
                }

            })
        }

    }

    override fun setValues() {

    }
}
