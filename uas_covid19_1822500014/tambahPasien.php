<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nik = $_POST['nik'];
		$nama = $_POST['nama'];
		$jenis_kelamin = $_POST['jenis_kelamin'];
		$golongan_darah = $_POST['golongan_darah'];
		$kecamatan = $_POST['kecamatan'];
		$kelurahan = $_POST['kelurahan'];
		$gejala_pasien = $_POST['gejala_pasien'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_pasien (id, nik, nama, jenis_kelamin, golongan_darah, kecamatan, kelurahan, gejala_pasien) VALUES ('', '$nik', '$nama', '$jenis_kelamin', '$golongan_darah', '$kecamatan', '$kelurahan', '$gejala_pasien')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pasien';
		}else{
			echo 'Gagal Menambahkan Pasien';
		}
		
		mysqli_close($con);
	}

?>