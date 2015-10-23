# DataToARFF

Aplikasi untuk mengubah Dataset yang bisa di download pada [UCI][uci] yang berformat data menjadi ARFF File yang berformat file.

### Dasar Pembuatan Aplikasi

Aplikasi ini saya buat untuk menyelesaikan tugas 2 Matakuliah Data Mining di Jurusan Informatika, MIPA, USK pada tahun ajaran 2015/2016. Tugas 2 tersebut meminta kami para mahasiswa untuk mengubah Dataset [Breast Cancer Wisconsin][bcw] dan [Abalone][abalone] menjadi sebuah file yang berisi data yang sama tetapi telah berformat ARFF File ( .arff ) sehingga dapat digunakan pada Aplikasi WEKA.

Kami para mahasiswa diizinkan untuk menggunakan Spreadsheet, membuat script sendiri, maupun tools lain yang sudah tersedia. Oleh karenanya, saya mencoba untuk membuat sebuah tools sendiri yang bukan hanya bisa saya gunakan, tetapi juga bisa digunakan oleh orang banyak. Dan pemikiran inilah yang akhirnya melahirkan tools DataToARFF ini.

### Input File

Untuk menggunakan tools ini, ada beberapa file yang harus anda siapkan, karena file tersebut nantinya akan digunakan sebagai file input dalam tools ini. Beberapa file tersebut yaitu :

* Names File ( .names )
* Data File ( .data )

### Output File

Hasil akhir dari tools ini berupa sebuah file yang berisi data yang kita inginkan, sesuai dengan format dan urutan yang telah kita tentukan sendiri. File tersebut dikenal dengan nama ARFF File ( .arff )

### Cara Penggunaan

Cara penggunaan yang lengkap bisa langsung anda lihat pada file [DataToARFF-Instruction][instruksi] yang telah kami sediakan. Tetapi disini akan dijelaskan sedikit mengenai cara penggunaannya :

* Buka executable jar File yang telah kami sediakan
* Pilih Names File ( .names ) yang anda miliki
* Tulislah Attribute sesuai dengan urutan yang ada pada data anda di kolom teks area "attribute di data"
* Tulislah Attribute sesuai dengan urutan yang anda inginkan pada file hasil nanti. ( Attribute yang ingin dihilangkan maka tidak perlu di tulis )
* Klik pada tombol "Lanjut >>"
* Pilihlah Data File ( .data ) untuk dataset yang akan anda konversikan
* Biarkan tools membaca jumlah baris pada Data File anda
* Klik tombol "Konversikan" untuk mengubah dataset anda menjadi format ARFF
* Pilih dimana ARFF File hasil akan anda simpan, jangan lupa untuk menambah ekstensi .arff ketika anda menulis nama file hasilnya
* Tunggu sejenak ....
* Selesai.

[Video Tutorial Cara Penggunaan][video]


License
----

* Muhammad Furqan ( 1308107010039 ) - [Jurusan Informatika][inf], [Fakultas Matematika dan Ilmu Pengetahuan Alam][fmipa], [Universitas Syiah Kuala][usk].

Anda diizinkan untuk mengembangkan serta menggunakan source code yang ada pada aplikasi - aplikasi disini. Tetapi kami sangat berharap untuk tidak menghilangkan nama kami selaku orang yang mengembangkan semua aplikasi yang ada disini dari awal.

### Website

* [Portal Bisnis Bersama][pbb]

### Social Media

* [Facebook][facebook]
* [Instagram][ig]



**Muhammad Furqan - Informatika, MIPA, USK**

   [uci]: <http://archive.ics.uci.edu/ml>
   [pbb]: <http://www.portalbisnisbersama.com>
   [bcw]: <http://archive.ics.uci.edu/ml/datasets/Breast+Cancer+Wisconsin+%28Diagnostic%29>
   [abalone]: <http://archive.ics.uci.edu/ml/datasets/Abalone>
   [facebook]: <https://www.facebook.com/furqan.muslim>
   [ig]: <https://instagram.com/muhammadfurqan39/>
   [instruksi]: <https://github.com/fueerqan/Data-Mining/blob/master/DataToARFF/DataToARFF-instruction.pdf>

   [inf]: <http://informatika.unsyiah.ac.id>
   [fmipa]: <http://fmipa.unsyiah.ac.id/>
   [usk]: <http://unsyiah.ac.id>
   
   [video]: <https://www.youtube.com/watch?v=85ue3X5ZOHQ>