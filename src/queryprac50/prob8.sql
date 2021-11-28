
# 여태까지 회사에 입사했던 사람들의 총 인원 수와 연도별 입사한 직원 수를 출력하시오.

SELECT '총 인원 수 :' 입사년도, COUNT(ENumber) 입사한_직원_수 FROM tEmployee
UNION
SELECT DATE_FORMAT(StartDate, '%Y'), COUNT(ENumber) FROM tEmployee
    GROUP BY DATE_FORMAT(StartDate, '%Y');
