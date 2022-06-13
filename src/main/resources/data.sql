/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  ADMIN
 * Created: Jun 13, 2022
 */

USE [LTNC]
GO
SET IDENTITY_INSERT [dbo].[users] ON 
GO
INSERT [dbo].[users] ([id], [address], [full_name], [email], [password], [username]) VALUES (1, N'Kim Liên, Nam Đàn', N'Nguyễn Hữu Nhân', N'nhan9ckl@gmail.com', N'$2a$10$EHIVo.PxEm5edeDMRgc6Z.UME6hUpkngOjeLwrSEGLh7K0yow8hUm', N'nhan')
GO
INSERT [dbo].[users] ([id], [address], [full_name], [email], [password], [username]) VALUES (2, N'Hà Nội', N'Đỗ Thị Diệp', N'nhan9ckl2@gmail.com', N'$2a$10$7gH0/bcvxA15vDrEFd/mv.m9l0yEoKwATpjOaE3X4tJ4PoMGlm/FC', N'diep')
GO
INSERT [dbo].[users] ([id], [address], [full_name], [email], [password], [username]) VALUES (3, N'TP HCM', N'Bùi Thị Thoa', N'nhan9ckl23@gmail.com', N'$2a$10$DfdhQM51qRu/JVU.t3Srpev5jnFKCcae5FybGgmFuObGfkJZC4Wwe', N'thoa')
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET IDENTITY_INSERT [dbo].[carts] ON 
GO
INSERT [dbo].[carts] ([id], [user_id]) VALUES (2, 1)
GO
SET IDENTITY_INSERT [dbo].[carts] OFF
GO
SET IDENTITY_INSERT [dbo].[categories] ON 
GO
INSERT [dbo].[categories] ([id], [alias], [name], [status]) VALUES (1, N'buatrua', N'Bữa trưa', 1)
GO
INSERT [dbo].[categories] ([id], [alias], [name], [status]) VALUES (2, N'trangmieng', N'Tráng miệng', 1)
GO
INSERT [dbo].[categories] ([id], [alias], [name], [status]) VALUES (3, N'douong', N'Đồ uống', 1)
GO
INSERT [dbo].[categories] ([id], [alias], [name], [status]) VALUES (4, N'buasang', N'Bữa sáng', 1)
GO
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
INSERT [dbo].[food] ([id], [alias], [created_by], [created_date], [image], [name], [origin_price], [promotion_price], [status], [updated_by], [updated_date], [view_count], [category_id]) VALUES (1, N'1', N'1', CAST(1.00 AS Numeric(19, 2)), N'1', N'1', 1, 1, 1, N'1', CAST(1.00 AS Numeric(19, 2)), 1, 1)
GO
INSERT [dbo].[cart_food] ([cart_id], [food_id], [quantity]) VALUES (2, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[orders] ON 
GO
INSERT [dbo].[orders] ([id], [created_time], [customer_address], [customer_message], [customer_name], [payment_method], [status], [total_price], [user_id]) VALUES (1, N'1', N'1', N'1', N'1', N'1', 1, 1, NULL)
GO
SET IDENTITY_INSERT [dbo].[orders] OFF
GO
INSERT [dbo].[order_food] ([food_id], [order_id], [quantity]) VALUES (1, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[roles] ON 
GO
INSERT [dbo].[roles] ([id], [name]) VALUES (1, N'ROLE_USER')
GO
INSERT [dbo].[roles] ([id], [name]) VALUES (2, N'ROLE_MODERATION')
GO
INSERT [dbo].[roles] ([id], [name]) VALUES (3, N'ROLE_ADMIN')
GO
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 1)
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (2, 1)
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (3, 1)
GO
