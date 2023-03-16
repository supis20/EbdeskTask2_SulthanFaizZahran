# EbdeskTask2_SulthanFaizZahran

1. Jelaskan apa itu SQL!

        SQL adalah sebuah bahasa pemrograman yang digunakan untuk mengelola dan mengakses data dalam sebuah 
        database. Dengan menggunakan SQL, kita dapat membuat, memperbarui, dan menghapus data dalam database 
        serta melakukan pencarian dan pengambilan data yang spesifik. Selain itu, SQL juga dapat digunakan 
        untuk membuat dan mengelola struktur database, memberikan hak akses pengguna ke database, dan 
        melakukan berbagai operasi lainnya. SQL digunakan secara luas di berbagai industri teknologi 
        informasi dan merupakan standar dalam manajemen data relasional.
        
        SQL digunakan oleh banyak jenis database, termasuk Oracle, MySQL, PostgreSQL, dan Microsoft SQL 
        Server. Karena SQL adalah bahasa standar, banyak aplikasi dapat menggunakan perintah SQL untuk 
        berinteraksi dengan berbagai jenis database.
        
2. Sebutkan apa itu DDL, DML, dan DCL dalam SQL beserta perbedaan nya?

        DDL, DML, dan DCL adalah tiga jenis perintah dalam SQL yang digunakan untuk mengelola database. DDL 
        digunakan untuk membuat, mengubah, atau menghapus objek database seperti tabel, indeks, atau tampilan. 
        DML digunakan untuk menambahkan, mengubah, atau menghapus data dalam tabel. Sedangkan DCL digunakan 
        untuk mengatur hak akses pengguna pada objek database.
        
        - DDL (Data Definition Language) terdiri dari perintah seperti CREATE, ALTER, dan DROP.
        - DML (Data Manipulation Language) terdiri dari perintah seperti INSERT, UPDATE, dan DELETE.
        - DCL (Data Control Language) terdiri dari perintah seperti GRANT dan REVOKE.
        
        Perbedaan utama antara ketiga jenis perintah ini adalah fokusnya. DDL digunakan untuk mengelola 
        struktur database, sedangkan DML digunakan untuk mengelola data dalam tabel. Sementara DCL digunakan 
        untuk mengatur hak akses pengguna pada objek database. Biasanya, DDL dan DML digunakan oleh pengguna 
        atau developer database, sedangkan DCL digunakan oleh administrator database untuk mengatur hak akses 
        pengguna pada objek database.

3. Periksalah file yang terlampir!

    a. Baca file tersebut (boleh menggunakan bahasa pemrograman apapun) lalu masukan data tersebut ke dalam sebuah database SQL (boleh menggunakan database SQL apapun        asalkan mudah diakses dan stabil!)
    
        Saya menggunakan database MySQL pada task ini karena menurut saya MySQL mudah diakses dan stabil. 
        Selain itu, saya mengetahui bahwa MySQL adalah salah satu database SQL yang populer dan banyak 
        digunakan oleh pengembang dan organisasi besar di seluruh dunia. Dukungan dan sumber daya online 
        untuk MySQL juga mudah ditemukan dan dapat membantu saya jika saya mengalami kesulitan dalam 
        mengelola database. Selain itu, MySQL dapat diintegrasikan dengan banyak bahasa pemrograman dan 
        platform aplikasi, yang akan memudahkan saya dalam mengembangkan aplikasi yang terhubung dengan 
        database MySQL. Oleh karena itu, saya memutuskan untuk menggunakan MySQL dalam task ini.
    
    b. Lakukanlah perbaikan atau normalisasi terhadap data tersebut sebelum dimasukan ke dalam database agar lebih efisien dan ekfektif dalam melakukan analisis pada          data tersebut
    
        Saya untuk mernomalisasi data ini dengan membuat API menggunakan springboot dengan library jpa. 
        Saya menggunakan ini, karena disini saya bisa sangat mudah dalam pembuatan relasi nya, seperti 
        dari table movie ke directors mempunyai relasi one to many. dan hanya menggunakan anotasi 
        @ElementCollections, one to many sudah terbuat
    
    
4. Waktunya melakukan analisis data!

   a. Grouping data tersebut berdasarkan sertifikasi film
        
        Berikut langkah - langkah untuk melakukan Grouping Data berdasarkan sertifikasi film di MySQL:
        1. Buka phpMyAdmin 
        2. Masuk kedalam table movie di dalam databsae db_movies
        3. Pilih Tab Sql untuk menuliskan query nya
        4. Ketik query ini 
                SELECT * FROM `movie` GROUP BY certificate;
        5. Maka hasil yang akan dikeluarkan seperti ini
        
![WhatsApp Image 2023-03-16 at 13 25 30](https://user-images.githubusercontent.com/86909749/225533695-20113d3b-84ca-4de8-b2eb-9db0d9171064.jpg)

   b. Tampilkan sutradara yang telah menyutradarai lebih dari 1 film dan film-film tersebut memiliki rating diatas 7.5
    
    
        Berikut langkah - langkah untuk melakukan Grouping Data berdasarkan sertifikasi film di MySQL:
        1. Buka phpMyAdmin 
        2. Masuk kedalam table movie di dalam databsae db_movies
        3. Pilih Tab Sql untuk menuliskan query nya
        4. Ketik query ini 
                SELECT movie_directors.directors, COUNT(movie_directors.movie_movie_id) AS total_film, 
                movie.rating 
                FROM movie 
                JOIN movie_directors ON movie.movie_id = movie_directors.movie_movie_id 
                WHERE movie.rating > 7.5 
                GROUP BY movie_directors.directors 
                HAVING COUNT(movie_directors.movie_movie_id) > 1;
        5. Maka hasil yang akan dikeluarkan seperti ini

![image](https://user-images.githubusercontent.com/86909749/225536316-ddfe917b-b8ab-4878-9875-9bcfc029f451.png)
    
   c. Tampilkan film apa saja yang meraih keuntungan dalam produksi nya
    
   
       Berikut langkah - langkah untuk melakukan Grouping Data berdasarkan sertifikasi film di MySQL:
        1. Buka phpMyAdmin 
        2. Masuk kedalam table movie di dalam databsae db_movies
        3. Pilih Tab Sql untuk menuliskan query nya
        4. Ketik query ini 
                SELECT * FROM `movie` WHERE income > budget;
        5. Maka hasil yang akan dikeluarkan seperti ini 
        
![image](https://user-images.githubusercontent.com/86909749/225537189-5848fde8-eaa2-481b-8197-2256b0809d81.png)

   d. Bulan mana yang memiliki jumlah film yang diproduksi terbanyak
   
   
        Berikut langkah - langkah untuk melakukan Grouping Data berdasarkan sertifikasi film di MySQL:
        1. Buka phpMyAdmin 
        2. Masuk kedalam table movie di dalam databsae db_movies
        3. Pilih Tab Sql untuk menuliskan query nya
        4. Ketik query ini 
                SELECT *, COUNT(movie_id) as total_film FROM `movie` GROUP by month ORDER BY total_film DESC
        5. Maka hasil yang akan dikeluarkan seperti ini 
        
![image](https://user-images.githubusercontent.com/86909749/225537793-1ae13800-5595-4c5b-9674-8dd4981c6ab5.png)

   e. Sebutkan 5 film apa saja yang memiliki rating tertinggi untuk perbulannya (urutkan dari rating yang terkecil ke yang terbesar)    
   
   
        Berikut langkah - langkah untuk melakukan Grouping Data berdasarkan sertifikasi film di MySQL:
        1. Buka phpMyAdmin 
        2. Masuk kedalam table movie di dalam databsae db_movies
        3. Pilih Tab Sql untuk menuliskan query nya
        4. Ketik query ini 
                SELECT movie_id, budget, certificate, filming_location, income, month, runtime, title, 
                year, high_rating
                FROM (
                  SELECT *, max(rating) as high_rating
                  FROM `movie`
                  GROUP BY `month`
                  ORDER BY high_rating desc
                  LIMIT 5
                  ) AS subquery
                  ORDER BY subquery.high_rating asc;
        5. Maka hasil yang akan dikeluarkan seperti ini 
   
![image](https://user-images.githubusercontent.com/86909749/225538007-fb769114-c993-4813-a99b-e85bd9fa48c4.png)

5.  Menambahkan sedikit tantangan! (Dapat dilakukan pada saat live interview)

    a. Sebutkan jenis-jenis relationship yang ada di SQL!
    
        Berikut jenis - jenis relationship yang ada di SQL:

        - One-to-One (1:1): Relasi antara dua tabel di mana setiap baris di tabel pertama memiliki 
           hubungan dengan tepat satu baris di tabel kedua, dan sebaliknya.
        - One-to-Many (1:N): Relasi antara dua tabel di mana setiap baris di tabel pertama dapat 
          memiliki hubungan dengan banyak baris di tabel kedua, tetapi setiap baris di tabel kedua 
          hanya memiliki hubungan dengan satu baris di tabel pertama.
        - Many-to-One (N:1): Relasi antara dua tabel di mana banyak baris di tabel pertama dapat 
          memiliki hubungan dengan satu baris di tabel kedua, tetapi setiap baris di tabel kedua 
          hanya memiliki hubungan dengan satu baris di tabel pertama.
        - Many-to-Many (N:N): Relasi antara dua tabel di mana banyak baris di tabel pertama dapat 
          memiliki hubungan dengan banyak baris di tabel kedua, dan sebaliknya.
    
    b. Buatlah menjadi 3 tabel baru yaitu tabel film, tabel pemeran film dan tabel sutradara dari file yang terlampir
    
        Table sudah dibuat terpisah menjadi 5 table dari awal, karena disini saya memakai anotasi
        @ElementCollections untuk membuat relasi nya, maka secara otomatis library Jpa sudah
        mengenerate table dan memisahkan berdasarkan relasinya
    
    c. Buat ER Diagram yang menunjukan hubungan antara 3 tabel tersebut
    
        Berikut langkah - langkah untuk membuat ERD di phpMyAdmin:
        1. Buka phpMyAdmin dan pilih database db_movies
        2. Pilih Tab Designer di bagian atas tampilan phpMyAdmin.
        3. Semua table yang sudah dibuat langsung terlihat
        4. Pilih Create Relationship di sebelah kiri untuk menghubungkan tabel dengan relasi yang 
           sesuai.
        5. Relasikan table berikut sesuai dengan Primary key dan Foreign key nya
        6. Maka hasilnya akan terlihat seperti berikut
    
![image](https://user-images.githubusercontent.com/86909749/225540686-873170e7-e66a-427f-81e6-6f282527b2d4.png)
    
    
    d. Lakukan query-query yang ada pada soal nomor 4 namun dengan kondisi tabel-tabel sudah terpisah (petunjuk: JOIN!)
    
        Berikut langkah - langkah untuk melakukannyaL:
        1. Buka phpMyAdmin 
        2. Masuk kedalam table movie di dalam databsae db_movies
        3. Pilih Tab Sql untuk menuliskan query nya
        4. Ketik query ini 
                SELECT movie.title, movie.rating, movie.runtime, movie.certificate, movie.month, movie.year, 
                movie.filming_location, movie.budget, movie.income, movie_directors.directors, movie_genres.genres, 
                movie_country_of_region.country_of_region, movie_stars.stars 
                FROM movie 
                JOIN movie_directors ON movie.movie_id = movie_directors.movie_movie_id 
                JOIN movie_genres ON movie.movie_id = movie_genres.movie_movie_id 
                JOIN movie_stars ON movie.movie_id = movie_stars.movie_movie_id 
                JOIN movie_country_of_region ON movie.movie_id = movie_country_of_region.movie_movie_id;
        5. Maka hasil yang akan dikeluarkan seperti ini 
        
![image](https://user-images.githubusercontent.com/86909749/225571853-eadde86b-cd08-43e7-9d28-e2b317691276.png)

