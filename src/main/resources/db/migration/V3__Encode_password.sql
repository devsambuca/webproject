-- расширение для postgres
CREATE extension if NOT EXISTS pgcrypto;
-- crypt(password, gen_salt('bf', 8)) функция шифрования паролей
-- (служит для усложнения подбора пароля с помощью радужныз таблиц
UPDATE usr SET password = crypt(password, gen_salt('bf', 8));