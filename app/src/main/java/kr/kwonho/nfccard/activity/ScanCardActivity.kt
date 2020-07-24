package kr.kwonho.nfccard.activity

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.nfc.tech.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.kwonho.nfccard.R

class ScanCardActivity : AppCompatActivity() {

    private val TAG = "ScanCardActivity"
    private var nfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_card)


    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume : " + intent.action)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        registNfcAdapter()
    }

    override fun onPause() {
        super.onPause()
        nfcAdapter?.disableForegroundDispatch(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun registNfcAdapter() {
        val ndefFilter = IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED).apply {
            addDataType("*/*")
        }

        val techFilter = IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED).apply {
            addDataType("*/*")
        }

        val tagFilter = IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED).apply {
            addDataType("*/*")
        }

        val filters = arrayOf(ndefFilter, techFilter, tagFilter)

        val tech0 = arrayOf(MifareUltralight::class.java.name, Ndef::class.java.name,
                            NfcA::class.java.name, NfcB::class.java.name, NfcF::class.java.name,
                            NfcV::class.java.name, IsoDep::class.java.name,
                            NdefFormatable::class.java.name)
        val tech1 = arrayOf(MifareClassic::class.java.name, Ndef::class.java.name,
                            NfcA::class.java.name, NfcB::class.java.name, NfcF::class.java.name,
                            NfcV::class.java.name, IsoDep::class.java.name,
                            NdefFormatable::class.java.name)


        val intent = Intent(this, this.javaClass).apply {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        val pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        nfcAdapter?.enableForegroundDispatch(this, pIntent, filters, arrayOf(tech0, tech1))
    }
}