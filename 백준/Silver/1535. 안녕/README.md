# [Silver II] 안녕 - 1535 

[문제 링크](https://www.acmicpc.net/problem/1535) 

### 성능 요약

메모리: 14332 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍, 브루트포스 알고리즘, 배낭 문제

### 제출 일자

2025년 7월 19일 22:33:10

### 문제 설명

<p>세준이는 성형수술을 한 후에 병원에 너무 오래 입원해 있었다. 이제 세준이가 병원에 입원한 동안 자기를 생각해준 사람들에게 감사하다고 말할 차례이다.</p>

<p>세준이를 생각해준 사람은 총 N명이 있다. 사람의 번호는 1번부터 N번까지 있다. 세준이가 i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다. 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.</p>

<p>세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다. 세준이의 체력은 100이고, 기쁨은 0이다. 만약 세준이의 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다. 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 사람의 수 N(≤ 20)이 들어온다. 둘째 줄에는 각각의 사람에게 인사를 할 때, 잃는 체력이 1번 사람부터 순서대로 들어오고, 셋째 줄에는 각각의 사람에게 인사를 할 때, 얻는 기쁨이 1번 사람부터 순서대로 들어온다. 체력과 기쁨은 100보다 작거나 같은 자연수 또는 0이다.</p>

### 출력 

 <p>첫째 줄에 세준이가 얻을 수 있는 최대 기쁨을 출력한다.</p>

