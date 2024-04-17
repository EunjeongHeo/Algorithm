select K.flavor
from (
    select f.flavor, (sum(j.total_order)+sum(f.total_order)) as s
    from ( first_half as f
          join
          july as j
          on
          f.flavor = j.flavor)
    group by f.flavor
) as K
order by K.s DESC

limit 3