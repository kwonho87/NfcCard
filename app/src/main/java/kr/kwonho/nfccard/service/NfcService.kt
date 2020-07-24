package kr.kwonho.nfccard.service

import android.nfc.cardemulation.HostApduService
import android.os.Bundle

class NfcService: HostApduService() {

    override fun onDeactivated(reason: Int) {
        TODO("Not yet implemented")
    }

    override fun processCommandApdu(commandApdu: ByteArray?, extras: Bundle?): ByteArray {
        TODO("Not yet implemented")
    }
}