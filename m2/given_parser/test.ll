target triple="x86_64"

define i64 @add()
{
LU0:
	%_retval_ = alloca i64
	%_P_x = alloca i64
	%_P_y = alloca i64
	%u0 = load i64* %x
	%u1 = load i64* %y
	%u2 = add i64 %u0, %u1
	store i64 %u2, i64* %_retval_
	br label %LU1
LU1:
	%u3 = load i64* %_retval_
	ret i64 %u3
}

define i64 @main()
{
LU2:
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
	%u4 = load i64* %a
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u4)
	%u5 = load i64* %b
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u5)
	%u6 = load i64* %c
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u6)
	store i64 0, i64* %_retval_
	br label %LU3
LU3:
	%u7 = load i64* %_retval_
	ret i64 %u7
}

declare i8* @malloc(i64)
declare void @free(i8*)
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00", align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00", align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00", align 1
@.read_scratch = common global i64 0, align 8
