package kr.kwonho.nfccard.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kr.kwonho.nfccard.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnScan.setOnClickListener(View.OnClickListener {
            Intent(this, ScanCardActivity::class.java).run {
                startActivity(this)
            }
        })

        btnList.setOnClickListener(View.OnClickListener {
            Intent(this, CardListActivity::class.java).run {
                startActivity(this)
            }
        })
    }
}