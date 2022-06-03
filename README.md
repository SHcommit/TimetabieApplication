# TimeTable_recommend application project!!

![header](https://capsule-render.vercel.app/api?type=Waving&color=gradient&height=200&animation=twinkling&section=header&text=MBTI%20추천%20TimeTable&fontSize=60&fontColor=FF9B00)

<div align=center><h3>About Team_</div>

* **Team Leader**   = <a href="https://github.com/sam0774">김석현</a>


* member =   <a href="https://github.com/MoonDooo">임경완</a>

* member = <a href="https://github.com/SHcommit">양승현</a>

---

<div align=center><h3>Target_</div>

* 컴퓨터공학과 학생 누구나

---

<div align=center><h3>App Info_</div>

`교양 과목의 수업활동(토론, 발표, 팀 프로젝트, 글쓰기 ...)을 16가지 MBTI 성격 유형을 바탕으로 새롭게 분석했습니다.`  

` 어플을 이용하는 유저의 MBTI 성격에 따라 흥미로운, 관심 있어 할 과목들의 패턴을 파악했습니다.`  

` 따라서 사용자들은 시간표를 구성하는데 있어, 우리 어플의 색다른 추천 알고리즘을 통해 시간표를 만들 수 있습니다.`  
  
` 전공 과목의 경우 학년 별 우선순위에 의한 추천 알고리즘을 적용했습니다.`  

<div align=center><h3>About Planning_</div>

>  앱의 기반인 '**시간표 추천**' 초기 목표를 중심으로 5~7번의 탐색, 토의를 통해 설계 과정을 기획 했습니다.

> 시간을 절약해 개발하기 위해 동시에 개발 할 수 있는 Github을 선택하게 되었습니다.

> 안드로이드 개발 디자인(<a href="https://developer.android.com/design">android interface design guidlines</a>)를 기반으로 개발 할 것입니다.

<div align=center><h3>App Design_</div>


<img width="300" alt="1" align="left" src="https://user-images.githubusercontent.com/96910404/169507843-46c76f37-f4cf-460d-8f1b-b468a437c472.png">

<img width="255" alt="2" src="https://user-images.githubusercontent.com/96910404/169507867-dfc1af25-4bc5-4715-bbcd-4c9861ac70cf.png">

![3](https://user-images.githubusercontent.com/96910404/169509367-d559ef89-6f73-40ec-8b5e-3ca987d739d3.jpeg)

<div align=center><h3>초기 기획 과정_ </div>

<img width="275" alt="1" align="left" src="https://user-images.githubusercontent.com/96910404/170806754-723096ca-e154-4739-b7b7-8bf146c7b227.jpeg">
<img width="275" alt="1" align="left" src="https://user-images.githubusercontent.com/96910404/170806755-51d47969-c604-474e-8143-42998737521d.jpeg">
<img width="275" alt="1" align="left" src="https://user-images.githubusercontent.com/96910404/170806757-97537aa3-d589-482f-bf9b-329aa974c111.jpeg">

<img width="275" alt="1" align="center" src="https://user-images.githubusercontent.com/96910404/170806756-982cf955-a02a-458c-9c90-6c2bd90e873c.jpeg">


<div align=center><h1>구현된 기능_ </div>

<div align=center><h3>백엔드_ </div>

<div>
dataBase : Oracle Database
</div>

> make 700+ students major, general_elective subjects in db. ( type : JSON)

<div>
use jsp
</div>

<div align=center><h3>안드로이드_ </div>


<div>
use jsp to JSON Serialization(SubjectListDTO)
</div>

> JSON 형식으로 만들어진 700개 이상의 전공/교양 학생 과목을 직렬화 작업수행

<div>
ripple animation을 구현 ( adapt button)
</div>
<div>
 <a href="https://github.com/wasabeef/recyclerview-animators">AlphaInAnimationAdapterAnimation</a/> 사용 (MbtiAcitivty)
 
</div>

> Mbti 타입별 설명 목록 recyclerView 를 사용하여 목록을 호출할 때

<div>
shared element transition 구현 (MbtiActivity to MbtiDetailActivity)
</div>

> https://developer.android.com/training/transitions/start-activity?hl=ko#java
>
>Mbti 타입별 설명 목록에서 recyclerView cell을 클릭했을 때 transition animate 발생
>
> > Activity-> Activity 간 이동시 shared element transition은 오류가 없지만 그 외의 경우 버그가 발생할 수 있습니다.


BottomNavigationView를 통한 화면 전환 & FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_CLEAR_TOP 부여
<div>
TextView에 스크롤 (activity_mbtidetail.xml)
</div>
<br/>

<div>
TableLayout을 통한 시간표 구현 (Model.TableCell)
</div>
<div>
시간표 추가, 초기화 기능 (PreviousLayout1~4)
</div>
<div>
이전 시간표 선택과 동시에 추가 기능(PreviousLayout1~4)
</div>
<div>
이전 시간표 저장
</div>
<div>
커스텀 다이얼로그 (Dialog_mbti Put&Show)
</div>
<div>
시간표에 TextUtils.TruncateAt 기능 적용
</div>
<div>
Glide를 통한 이미지 호출
</div>
<br/>

<div>
MBTI algorithm 적용
</div>
<div>
사용자의 mbti 입력에 대한 예외 처리 구현
</div>
<div>
사용자의 인적사항 입력시 예외처리 구현
</div>
<div>
부분 프래그먼트와 bundle, intent 등 사용한 객체 전달.
</div>

<br/>
<div>
MVC 아키텍쳐 적용
</div>
<div>
협업 과정에서 코드 컨벤션(Code Convention) 스타일을 준수하기 위해 노력함.
</div>
<div>
Github을 통한 프로젝트 버전 관리
</div>

![2](https://user-images.githubusercontent.com/96910404/171493337-339d82dd-f91c-4e2b-b2b3-0601364b1f2f.gif)

<div>
협업 과정에서 Data Transfer Object(DTO), Value Object(VO) 개념을 도입해 클래스 간 역할 구분
</div>
  
<div>
  시연 영상!! https://www.youtube.com/watch?v=LeGCNOoITgc
</div>
<div>
</div>
<div>
</div>
<div>
</div>
<div>
</div>
<div>
</div>
<div>
</div>
<div>
</div>
<div>
</div>
