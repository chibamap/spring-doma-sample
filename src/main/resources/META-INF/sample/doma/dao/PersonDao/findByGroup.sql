select
  /*%expand*/*
from
  person
where
  group_id in (
    select id from groups where
    /*%if group.id != null */
    `id` = /* group.id */2
    /*%end */
    /*%if group.name != null */
    and `name` = /* group.name */'hoge'
    /*%end */
  )
