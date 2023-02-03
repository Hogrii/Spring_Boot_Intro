1. H2 console 다운로드
2. http://www.h2database.com/html/main.html에서 windows installer 다운
3. cmd를 이용해 다운 받은 경로 내의 H2 > bin > h2.bat 실행 
4. C 드라이브 > Users > Admin > test.mv.db 파일이 있는지 확인 
5. JDBC URL -> jdbc:h2:tcp://localhost/~/test로 변경 -> h2.bat 실행하면 자동으로 창이 하나 열림 만약 안열리면 ip주소를 localhost로 변경시켜주면 됨
6. 콘솔창에서 sql문 작성하면 작동한다.
7. h2.bat 파일을 종료시키면 H2 console은 당연히 종료되니 참고