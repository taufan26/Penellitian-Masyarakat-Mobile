<?php
include 'config.php';

if ($_POST) {
	
	//data
	$user_id = $_POST['user_id'] ?? '';

	$response = [];//data response

	//cek username didalam database
	$userQuery = $connection->prepare("SELECT * FROM biodata where biodata_user_id = ?");
	$userQuery->execute(array($user_id));
	$query = $userQuery->fetch();

	if ($userQuery->rowCount() == 0) {
		$response['status'] = false;
		$response['message'] = "Tidak Ada Biodata";
	} else {
		//ambil password di db

		$passwordDB = $query['biodata_user_id'];

		if (strcmp($user_id, $passwordDB) === 0) {
			$response['status'] = true;
			$response['message'] = "Biodata Berhasil Ditampilkan";
			$response['data'] = [
				'id_biodata' => $query['id_biodata'],
				'users' => $query['users'],
				'biodata_user_id' => $query['biodata_user_id'],
				'biodata_sex' => $query['biodata_sex'],
				'biodata_college' => $query['biodata_college'],
				'biodata_study_program' => $query['biodata_study_program'],
				'biodata_position' => $query['biodata_position'],
				'biodata_birthplace' => $query['biodata_birthplace'],
				'biodata_birthdate' => $query['biodata_birthdate'],
				'biodata_ktp_number' => $query['biodata_ktp_number'],
				'biodata_hp_number' => $query['biodata_hp_number'],
				'biodata_telephone_number' => $query['biodata_telephone_number'],
				'biodata_address' => $query['biodata_address'],
				'biodata_personal_web' => $query['biodata_personal_web'],
				'biodata_image' => $query['biodata_image']
			];
		}else{
			$response['status'] = false;
			$response['message'] = "Tidak Ada Biodata";
		}
	}

	//data json
	$json = json_encode($response, JSON_PRETTY_PRINT);

	echo $json;
	
}

?>