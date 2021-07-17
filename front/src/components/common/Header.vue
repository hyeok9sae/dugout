<template>
	<header class="header">
		<p class="logo-text">
			<span>더그</span>
			<span class="text-gray">아웃</span>
		</p>
		<section class="nav-button">
			<button class="button">로그인</button>
		</section>
	</header>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
@font-face {
	font-family: 'designhouseOTFLight00';
	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_three@1.0/designhouseOTFLight00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
.text-gray {
	color: #868e96;
}
.header {
	display: flex;
	justify-content: space-between;
	height: 72px;
	.logo-text {
		font-family: 'designhouseOTFLight00';
		font-size: 2rem;
		margin: auto 0;
	}
	.nav-button {
		display: flex;
		align-items: center;
		.button {
			width: 72px;
			height: 32px;
			border-radius: 16px;
			border: none;
			background: #ced4da;
		}
	}
}
</style>
