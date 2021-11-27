
# 가구류 제품들의 선호도 조사를 위하여 고객들이 가구류 제품들의 주문을 몇 번 했는지 고객코드별로 출력하시오.
# (가구류의 생산코드는 P2~로 시작한다)

SELECT CNumber 고객코드, COUNT(*) 주문건수 FROM tOrder
    WHERE PNumber LIKE 'P2%'
        GROUP BY CNumber;