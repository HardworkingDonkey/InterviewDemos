-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- 找出连续出现三次的数字

SELECT DISTINCT l1.Num ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE l2.Id = l1.Id + 1
  AND l3.Id = l2.Id + 1
  AND l1.Num = l2.Num
  AND l2.Num = l3.Num
