# 사진이미지를 업로드하여 이미지 갤러리 BBS로 변환

* spring framework에서는 기본적으로 Text 위주의 project만 지원한다.
* file(종류에 관계 없이)을 upload 하기 위해서 apache에서 지원하는 dependency 도움을 
받아야 한다.
* commons-io, commons-fileupload

## file upload 할수 있도록 서버 context를 설정해 주어야 한다.
* file-context.xml 파일을 설정하여 file upload를 설정하는데
* context-param에서 핸들링 할 수 있도록 root-context.xml 과 같은 위치 작성
* file 선택을 하기 위해 input type="file" tag를 추가하고
* form tag enctype="multipart/form-data"
* upload하는 파일의 type을 제한하고 싶을때 accept="image/*" 설정해 주면 된다.
* 파일의 확장자를 검사하여 제한하고 싶을때 accept = ".gif, .jpg, .jpeg, .png"
* 미디어타입과 확장자를 검사하여 제한하고 싶을때 accept="video/mp4, audio/mp3, image/png"

## 첨부파일이 게시판에서 CRUD 구현
1. insert 
* 파일을 업로드할때 파일이름 UUID 부착하기
* 파일을 UUID를 부착하여 upload를 실행하고, UUID가 부착된 파일이름을 게시글의 file명 필드에 추가한 후
insert 수행하기

2. delete
* 업로드된 첨부파일을 삭제작업 수행 우선
* seq값으로 게시글을 가져오고 file명 필드에서 첨부파일 이름을 getter 하여 upload 폴더의 파일 삭제
* 해당하는 게시글을 삭제
* 게시글은 없는데 필요없는 주인없는 파일들이 upload폴더에 쌓이게 된다.

3. update 
* seq 값을 게시글을 가져와서 write.jsp에 보이고 변경할 데이터들 입력받기
* 파일이 첨부가 되면, 기존의 파일을 삭제하고, 새로운 파일을 upload하고, 새로 업로드 된 파일이름을
다시 file명 필드에 저장한 후 Update를 수행해야 한다.
* 파일이 첨부가 안되었으면 : 기존의 file명 필드에 저장된 값이 변경되지 않도록 하면서 update를 수행

