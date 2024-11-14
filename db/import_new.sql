-- Insert into 'type' table
INSERT INTO type (id, name) VALUES
                                (1, 'Keele töötlemine'),
                                (2, 'Pildituvastus'),
                                (3, 'Andmeanalüüs'),
                                (4, 'Masinnägemine');

-- Insert into 'role' table
INSERT INTO role (id, name) VALUES
                                (1, 'Admin'),
                                (2, 'Kasutaja');

-- Insert into 'user' table
INSERT INTO "user" (id, username, password, points, role_id, status, email, created_at, updated_at) VALUES
                                                                                                        (1, 'valter', 'hashedpassword', 250, 2, 'A', 'valteraro@gmail.com', '2024-11-14 10:00:00', NULL),
                                                                                                        (2, 'mariAIguru', 'hashedpassword', 500, 2, 'A', 'mari@tehisintellekt.ee', '2024-11-14 10:05:00', NULL);

-- Insert into 'ai_site' table
INSERT INTO ai_site (id, name, company, description, link, type_id, user_id, status, pricing_type, created_at, updated_at) VALUES
                                                                                                                               (1, 'ChatGPT', 'OpenAI', 'Mitmekeelne juturobot, mis aitab igapäevaküsimustele vastuseid leida.', 'https://chat.openai.com', 1, 1, 'A', 'freemium', '2024-11-14 10:10:00', NULL),
                                                                                                                               (2, 'Midjourney', 'Midjourney Inc.', 'Pildigeneraator, mis suudab luua realistlikke ja kunstipäraseid pilte.', 'https://midjourney.com', 4, 2, 'A', 'paid', '2024-11-14 10:20:00', NULL);

-- Insert into 'user_story' table
INSERT INTO user_story (id, user_id, ai_site_id, review_score, experience, created_at, updated_at) VALUES
                                                                                                       (1, 1, 1, 5, 'ChatGPT on aidanud mul kiiremini leida teavet ja vastuseid tööalastele küsimustele.', '2024-11-14 10:15:00', NULL),
                                                                                                       (2, 2, 2, 4, 'Midjourney pakub hämmastavaid visuaale, mida saan kasutada oma graafilise disaini projektides.', '2024-11-14 10:25:00', NULL);

-- Insert into 'evaluation' table
INSERT INTO evaluation (id, score, comment, user_id, ai_sites_id, created_at, updated_at) VALUES
                                                                                              (1, 5, 'ChatGPT on parim abivahend igapäevaste küsimuste jaoks. Super kasulik!', 1, 1, '2024-11-14 10:30:00', NULL),
                                                                                              (2, 4, 'Midjourney pildid on fantastilised, kuid hind on natuke kõrge.', 2, 2, '2024-11-14 10:35:00', NULL);

-- Insert into 'evaluation_feedback' table
INSERT INTO evaluation_feedback (id, user_id, evaluation_id, feedback, created_at) VALUES
                                                                                       (1, 1, 1, true, '2024-11-14 10:40:00'),
                                                                                       (2, 2, 2, true, '2024-11-14 10:45:00');

-- Insert into 'comment' table
INSERT INTO comment (id, user_id, ai_site_id, content, created_at, updated_at) VALUES
                                                                                   (1, 1, 1, 'Suurepärane abimees nii tööl kui kodus!', '2024-11-14 10:50:00', NULL),
                                                                                   (2, 2, 2, 'Midjourney on parim tööriist, mida olen oma disainitööde jaoks kasutanud.', '2024-11-14 10:55:00', NULL);

-- Insert into 'picture' table
INSERT INTO picture (id, data, ai_sites_id, evaluation_id) VALUES
    (1, '\\x89504e470d0a1a0a0000000d49484452...', 2, NULL);  -- Assume a valid bytea data value for the image
