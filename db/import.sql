INSERT INTO public.role (id, name) VALUES (1, 'admin');
INSERT INTO public.role (id, name) VALUES (2, 'user');

INSERT INTO public."user" (id, username, password, points, role_id, status, email, created_at, updated_at) VALUES (2, 'Valter', '123', 5, 1, 'A', 'valteraro@gmail.com', '2023-05-07 14:04:08.000000', null);

INSERT INTO public.type (id, name) VALUES (1, 'text-2-text');
INSERT INTO public.type (id, name) VALUES (2, 'text-2-picture');

INSERT INTO public.ai_site (id, name, company, description, link, type_id, user_id, status, created_at, updated_at) VALUES (1, 'ChatGPT', 'OpenAi', 'ChatGPT is an AI language model based on GPT-4. It generates human-like text and answers questions. It was trained on data until September 2021. Some responses may be outdated or inaccurate, but overall the performance is great.', 'https://chat.openai.com/', 1, 2, 'A', '2023-05-07 14:08:43.000000', null);
