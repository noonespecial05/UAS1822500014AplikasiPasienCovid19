<?php 

require_once('koneksi.php');

$sql = "SELECT * FROM tb_pasien";

$r = mysqli_query($con, $sql);

$result = array();

while ($row = mysqli_fetch_array($r)) {
	array_push($result, array(
		'nik' => $row['nik'],
		'nama' => $row['nama'],
		'jenis_kelamin' => $row['jenis_kelamin'],
		'golongan_darah' => $row['golongan_darah'],
		'kecamatan' => $row['kecamatan'],
		'kelurahan' => $row['kelurahan'],
		'gejala_pasien' => $row['gejala_pasien']
	));
}

echo json_encode(array('result'=>$result));

mysqli_close($con);

 ?>