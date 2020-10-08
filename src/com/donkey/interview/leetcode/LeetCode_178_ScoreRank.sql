-- 自定义RANK() --
-- 90  1 --
-- 89  2 --
-- 89  2 --
-- 89  2 --
-- 88  3 --
SELECT Score, `Rank`
FROM (
    SELECT Score,
    @cur_rank :=  CAST(IF(Score = @prev, @cur_rank, @inc_rank) AS SIGNED) `Rank`,
    @prev := Score,
    @inc_rank := @cur_rank + 1
    FROM Scores, (
        SELECT @cur_rank := 0, @prev := NULL, @inc_rank := 1
    ) t1
    ORDER BY Score DESC
) t2