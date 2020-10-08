package com.example.sozlukuygulamasi

class Kelimelerdao {

    fun tumKelimeler(vt: VeritabaniYardimcisi): ArrayList<Kelimeler> {
        val kelimelerListesi = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler", null)
        while (c.moveToNext()) {
            val kelime = Kelimeler(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce")))
            kelimelerListesi.add(kelime)
        }
        return kelimelerListesi
    }
    fun aramaYap(vt: VeritabaniYardimcisi,aramaKelime:String): ArrayList<Kelimeler> {
        val kelimelerListesi = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce LIKE '%$aramaKelime%'", null)
        while (c.moveToNext()) {
            val kelime = Kelimeler(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce")))
            kelimelerListesi.add(kelime)
        }
        return kelimelerListesi
    }
}