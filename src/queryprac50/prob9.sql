
# 회사에서 제공해주는 기숙사에 머무를 수 있는 인원의 제한을 위해 부서와 직급, 그리고 현재 거주지를 따져 제한하려고 한다. 이에 따라 부서명과 직급명, 직원명 그리고 현재 직원의 주소를 출력하시오
# (부서코드, 직급코드가 아닌 부서명, 직급명으로 출력되어야 한다.)

SELECT (SELECT DName FROM tDepartment dept WHERE emp.DNumber = dept.DNumber) 부서명,
       (SELECT RName FROM tRank posi WHERE emp.RNumber = posi.RNumber) 직급명,
       EName 직원명,
       EAddr 직원주소
        FROM tEmployee emp;
