package com.smartheard.kotlinrecyclerviewex1.RestAPI

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smartheard.kotlinrecyclerviewex1.R
import kotlinx.android.synthetic.main.rest_api_view.*
import org.json.JSONException
import org.json.JSONArray
import org.json.JSONObject

class RestAPIView : AppCompatActivity() {

    private var requestQueue: RequestQueue? = null
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rest_api_view)

        this.setTitle("Rest API")
        textView = findViewById<TextView>(R.id.tv_users)

        requestQueue = Volley.newRequestQueue(this)
        btnFetchData.setOnClickListener {
            jsonParse()
        }
    }

    private fun jsonParse() {

      val url = "https://api.github.com/search/users?q=eyehunt"

        val request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
                response ->try {
            var strResp = response.toString()

            val jsonObject = JSONObject(strResp)
            val jsonArray: JSONArray = jsonObject.getJSONArray("items")

            var str_user: String = ""
            for (i in 0 until jsonArray.length()) {
                var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                str_user = str_user + "\n" + jsonInner.get("login")
            }
            textView!!.text = "response : $str_user "
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener {
                error -> error.printStackTrace()
        })
        requestQueue?.add(request)
    }
}