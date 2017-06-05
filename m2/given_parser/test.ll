target triple="x86_64"

define i64 @mod(i64 %a, i64 %b)
{
LU0:
	%_retval_ = alloca i64
	%_P_a = alloca i64
	%_P_b = alloca i64
	store i64 %a, i64* %_P_a
	store i64 %b, i64* %_P_b
	%u0 = load i64* %_P_a
	%u1 = load i64* %_P_a
	%u2 = load i64* %_P_b
	%u3 = sdiv i64 %u1, %u2
	%u4 = load i64* %_P_b
	%u5 = mul i64 %u3, %u4
	%u6 = sub i64 %u0, %u5
	store i64 %u6, i64* %_retval_
	br label %LU1
LU1:
	%u7 = load i64* %_retval_
	ret i64 %u7
}

define void @hailstone(i64 %n)
{
LU2:
	%_P_n = alloca i64
	store i64 %n, i64* %_P_n
	%u26 = trunc i64 1 to i1
	br i1 %u26, label %LU4, label %LU11
LU3:
	ret void
LU4:
	%u8 = load i64* %_P_n
	%u9 = load i64* %_P_n
	%u10 = call i64 @mod(i64 %u9, i64 2)
	%u11 = icmp eq i64 %u10, 1
	%u13 = zext i1 %u11 to i64
	%u14 = trunc i64 %u13 to i1
	br i1 %u14, label %LU5, label %LU6
	%u27 = trunc i64 1 to i1
	br i1 %u27, label %LU4, label %LU11
LU5:
	%u15 = load i64* %_P_n
	%u16 = mul i64 3, %u15
	%u17 = add i64 %u16, 1
	store i64 %u17, i64* %_P_n
	br label %LU7
LU6:
	%u18 = load i64* %_P_n
	%u19 = sdiv i64 %u18, 2
	store i64 %u19, i64* %_P_n
	br label %LU7
LU7:
	%u20 = load i64* %_P_n
	%u21 = icmp sle i64 %u20, 1
	%u23 = zext i1 %u21 to i64
	%u24 = trunc i64 %u23 to i1
	br i1 %u24, label %LU8, label %LU9
LU8:
	%u25 = load i64* %_P_n
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u25)
	br label %LU3
LU9:
	br label %LU10
LU10:
LU11:
	br label %LU3
}

define i64 @main()
{
LU12:
	%_retval_ = alloca i64
	%num = alloca i64
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64* %num)
	%u28 = load i64* %num
	call void @hailstone(i64 %u28)
	store i64 0, i64* %_retval_
	br label %LU13
LU13:
	%u30 = load i64* %_retval_
	ret i64 %u30
}

declare i8* @malloc(i64)
declare void @free(i8*)
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00", align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00", align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00", align 1
@.read_scratch = common global i64 0, align 8
