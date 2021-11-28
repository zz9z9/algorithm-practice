
# 2022년 1월에 반품이 발생한 직원을 확인하여 패널티를 부과하려 한다. 이에 해당하는 직원명을 출력하시오.

SELECT EName 직원명 FROM tEmployee
    WHERE ENumber IN (
        SELECT ENumber FROM tProduction WHERE PNumber IN (
            SELECT PNumber FROM tOrder WHERE ONumber IN (
                SELECT ONumber FROM tReturn WHERE DATE_FORMAT(RDate, '%Y%m') = '202201'
                )
            )
        );