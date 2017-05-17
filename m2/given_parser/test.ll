target triple="x86_64"
%struct.simple = type {i64}
%struct.foo = type {i64, i64, %struct.simple*}

define void @tailrecursive()
{
LU0:
	%_P_num = alloca i64
	%unused = alloca %struct.foo*
	store i64 %num, i64* %_P_num
	%u0 = load i64* %_P_num
	%u1 = icmp sle i64 %u0, 0
	br i1 %u1, label %LU2, label %LU3
LU1:
	ret void
LU2:
	br label %LU1
LU3:
	br label %LU4
LU4:
	%u2 = load i64* %_P_num
	%u3 = sub i64 %u2, 1
	call void @tailrecursive(i64 %u3)
}

define i64 @add()
{
LU5:
	%_retval_ = alloca i64
	%_P_x = alloca i64
	%_P_y = alloca i64
	store i64 %x, i64* %_P_x
	store i64 %y, i64* %_P_y
	%u5 = load i64* %_P_x
	%u6 = load i64* %_P_y
	%u7 = add i64 %u5, %u6
	store i64 %u7, i64* %_retval_
	br label %LU6
LU6:
	%u8 = load i64* %_retval_
	ret i64 %u8
}

define i64 @ackermann()
{
LU7:
	%_retval_ = alloca i64
	%_P_m = alloca i64
	%_P_n = alloca i64
	store i64 %m, i64* %_P_m
	store i64 %n, i64* %_P_n
	%u9 = load i64* %_P_m
	%u10 = icmp eq i64 %u9, 0
	br i1 %u10, label %LU9, label %LU10
LU8:
	%u25 = load i64* %_retval_
	ret i64 %u25
LU9:
	%u11 = load i64* %_P_n
	%u12 = add i64 %u11, 1
	store i64 %u12, i64* %_retval_
	br label %LU8
LU10:
	br label %LU11
LU11:
	%u13 = load i64* %_P_n
	%u14 = icmp eq i64 %u13, 0
	br i1 %u14, label %LU12, label %LU13
LU12:
	%u15 = load i64* %_P_m
	%u16 = sub i64 %u15, 1
	%u17 = call i64 @ackermann(i64 %u16, i64 1)
	store i64 %u17, i64* %_retval_
	br label %LU8
LU13:
	%u18 = load i64* %_P_m
	%u19 = sub i64 %u18, 1
	%u20 = load i64* %_P_m
	%u21 = load i64* %_P_n
	%u22 = sub i64 %u21, 1
	%u23 = call i64 @ackermann(i64 %u20, i64 %u22)
	%u24 = call i64 @ackermann(i64 %u19, i64 %u23)
	store i64 %u24, i64* %_retval_
	br label %LU8
}

define i64 @main()
{
LU14:
	%_retval_ = alloca i64
	%a = alloca i64
	%b = alloca i64
	%c = alloca i64
	%d = alloca i64
	%e = alloca i64
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %a)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %b)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %c)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %d)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %e)
	%u26 = load i64* %a
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u26)
	%u27 = load i64* %b
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u27)
	%u28 = load i64* %c
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u28)
	store i64 0, i64* %_retval_
	br label %LU15
LU15:
	%u29 = load i64* %_retval_
	ret i64 %u29
}

declare i8* @malloc(i64)
declare void @free(i8*)
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00", align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00", align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00", align 1
@.read_scratch = common global i64 0, align 8
