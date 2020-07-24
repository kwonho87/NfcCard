package kr.kwonho.nfccard.activity

import android.app.Activity
import android.os.Bundle
import kr.kwonho.nfccard.R

class CardListActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)
    }
}